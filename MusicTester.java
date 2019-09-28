import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

class MusicTester {

    void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("GOT SEQUENCER!!");
        } catch (MidiUnavailableException midiUnavailable) {
            System.out.println("DO SOMETHING"); //TODO
        }
    }
}
