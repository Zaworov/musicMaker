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

            MidiEvent startNote = getNote(NOTE_ON_COMMAND);
            MidiEvent endNote = getNote(NOTE_OFF_COMMAND);
            track.add(startNote);
            track.add(endNote);

            sequencer.setSequence(sequence);
            sequencer.start();
        } catch (MidiUnavailableException | InvalidMidiDataException midiUnavailable) {
            midiUnavailable.printStackTrace();
        }
    }

    private MidiEvent getNote(int commandNo) throws InvalidMidiDataException {
        ShortMessage messageA = new ShortMessage();
        messageA.setMessage(commandNo, 1, 64, 100); // data1 -> pitch (1-127), data2 -> note length
        return new MidiEvent(messageA, 1);
    }

    private void changeInstrument(Track track, int instrument) throws InvalidMidiDataException {
        ShortMessage changeMessage = new ShortMessage();
        changeMessage.setMessage(192, 1, instrument, 0);
        MidiEvent changeInstrument = new MidiEvent(changeMessage, 1);
        track.add(changeInstrument);
    }
}
