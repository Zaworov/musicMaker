import javax.sound.midi.*;

class MusicMachine {
    private static final int NOTE_ON_COMMAND = 144;
    private static final int NOTE_OFF_COMMAND = 128;

    void play(int instrument, int note) throws MidiUnavailableException {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            changeInstrument(track, instrument);

            MidiEvent startNote = createMidiEvent(NOTE_ON_COMMAND, 1, 64, 100, 1);
            MidiEvent endNote = createMidiEvent(NOTE_OFF_COMMAND, 1, 64, 100, 4);
            track.add(startNote);
            track.add(endNote);

            sequencer.setSequence(sequence);
            sequencer.start();
        } catch (MidiUnavailableException | InvalidMidiDataException midiUnavailable) {
            midiUnavailable.printStackTrace();
        }
    }

    private MidiEvent createMidiEvent(int commandNo, int channel, int data1, int data2, int beat) throws InvalidMidiDataException {
        MidiEvent event = null;
        try {
            ShortMessage messageA = new ShortMessage();
            messageA.setMessage(commandNo, channel, data1, data2); // data1 -> pitch (1-127), data2 -> note length for comman NOTE_ON and NOTE_OFF
            event = new MidiEvent(messageA, beat);
        } catch (Exception notCreated) {}
        return event;
    }

    private void changeInstrument(Track track, int instrument) throws InvalidMidiDataException {
        ShortMessage changeMessage = new ShortMessage();
        changeMessage.setMessage(192, 1, instrument, 0);
        MidiEvent changeInstrument = new MidiEvent(changeMessage, 1);
        track.add(changeInstrument);
    }
}
