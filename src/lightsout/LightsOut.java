 

/**
 *
 * @author David
 */
public class LightsOut {
    private final int length;
    private boolean[] lights;
    
    public LightsOut(int length) {
        this.length = length;
        this.lights = new boolean[length]; 
                
        int n = 2 * length;
        
        for (int i = 0; i < n; i++) {
            this.move((int)(Math.random() * length));            
        }
    }

    public boolean isOver() {
        for(boolean b : lights) if(b) return false;
        return true;
    }
    
    public void move(int index) {
        this.toggle(index);
        this.toggle(index - 1);
        this.toggle(index + 1);
    }
    
    private void toggle(int index) {
        if (!this.withinBounds(index)) {
            return;
        }
        
        this.lights[index] = !this.lights[index];
    }
            
    private boolean withinBounds(int index) {
        return index >= 0 && index < length;
    }
    
    public String toString() {
        String ON = "O";
        String OFF = "-";       
        String board = "";
        
        for (int i = 0; i < length; i++) {
            board += i + "  "; // 2 Spaces
        }
        board += "\n";
        for (boolean light : lights) {            
            board += ((light) ? ON : OFF) + "  "; // 2 Spaces
        }
        return board;
    }
}
