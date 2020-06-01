//package out;

import javax.sound.midi.MidiUnavailableException;

public class Launcher {

    public static void main(String[] args) throws MidiUnavailableException {
        int instrument = 15;
        int tempo = 220;
        GUI gui = new GUI();
        gui.generateInterface();

        MusicMachine musicMachine = new MusicMachine();
        musicMachine.run(gui, instrument, tempo);
    }

}
