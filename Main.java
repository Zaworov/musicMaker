import javax.sound.midi.MidiUnavailableException;

public class Main {
    public static void main (String[] args) throws MidiUnavailableException {
//        if (args.length < 2) throw new RuntimeException("You need to give at least two numerical arguments!");

//        int instrument = Integer.parseInt(args[0]);
        int instrument = 13;
//        int note = Integer.parseInt(args[1]);
        int note = 64;

        MusicMachine musicMachine = new MusicMachine();
        musicMachine.play(instrument, note);
    }
}
