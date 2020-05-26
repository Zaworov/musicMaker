import javax.sound.midi.*;

class MusicMachine implements ControllerEventListener {
    private static final int NOTE_ON_COMMAND = 144;
    private static final int NOTE_OFF_COMMAND = 128;
    public static final int CONTROLLER_EVENT_COMMAND = 176;

    void play(int instrument, int tempo) throws MidiUnavailableException {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] controlledEvents = {127};
            sequencer.addControllerEventListener(this, controlledEvents);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            changeInstrument(track, instrument); //TODO Use createMidiEventHere

            for (int i = 1; i < 61; i += 4) {
                track.add(createMidiEvent(NOTE_ON_COMMAND, 1, i, 100, i));
                track.add(createMidiEvent(CONTROLLER_EVENT_COMMAND, 1, 127, 0, i));
                track.add(createMidiEvent(NOTE_OFF_COMMAND, 1, i, 100, i + 2));
            }

            play(tempo, sequencer, sequence);
        } catch (MidiUnavailableException | InvalidMidiDataException midiUnavailable) {
            midiUnavailable.printStackTrace();
        }
    }

    private void play(int tempo, Sequencer sequencer, Sequence sequence) throws InvalidMidiDataException {
        sequencer.setSequence(sequence);
        sequencer.setTempoInBPM(tempo);
        sequencer.start();
    }

    private static MidiEvent createMidiEvent(int commandNo, int channel, int data1, int data2, int measure) {
        MidiEvent event = null;
        try {
            ShortMessage messageA = new ShortMessage();
            messageA.setMessage(commandNo, channel, data1, data2); // data1 -> pitch (1-127), data2 -> note length for comman NOTE_ON and NOTE_OFF
            event = new MidiEvent(messageA, measure);
        } catch (Exception notCreated) {
        }
        return event;
    }

    private void changeInstrument(Track track, int instrument) throws InvalidMidiDataException {
        ShortMessage changeMessage = new ShortMessage();
        changeMessage.setMessage(192, 1, instrument, 0);
        MidiEvent changeInstrument = new MidiEvent(changeMessage, 1);
        track.add(changeInstrument);
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("LA");
    }
}
