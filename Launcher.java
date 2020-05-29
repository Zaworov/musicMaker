//package out;

import javax.sound.midi.MidiUnavailableException;

public class Launcher {

    public static void main(String[] args) throws MidiUnavailableException {
//        if (args.length < 2) throw new RuntimeException("You need to give at least two numerical arguments!");

//        int instrument = Integer.parseInt(args[0]);
        int instrument = 14;
//        int note = Integer.parseInt(args[1]);
        int tempo = 220;
        GUI gui = new GUI();
        gui.generateInterface();

        MusicMachine musicMachine = new MusicMachine();
        musicMachine.play(instrument, tempo);
    }

}
