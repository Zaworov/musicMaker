import javax.sound.midi.*;

class MusicMachine {
    private static final int NOTE_ON_COMMAND = 144;
    private static final int NOTE_OFF_COMMAND = 128;

    void play(int instrument, int tempo) throws MidiUnavailableException {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            changeInstrument(track, instrument); //TODO Use createMidiEventHere

            for (int i = 1; i < 61; i += 4) {
                MidiEvent startNote = createMidiEvent(NOTE_ON_COMMAND, 1, i, 100, i);
                MidiEvent endNote = createMidiEvent(NOTE_OFF_COMMAND, 1, i, 100, i + 2);
                track.add(startNote);
                track.add(endNote);
                System.out.println("ADDED");
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

    private MidiEvent createMidiEvent(int commandNo, int channel, int data1, int data2, int measure) throws InvalidMidiDataException {
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
}
