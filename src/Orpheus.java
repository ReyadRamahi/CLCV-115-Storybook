public class Orpheus {
    private boolean sword;
    private boolean coin;
    private boolean mirror;
    private boolean torch;
    private boolean lyre;
    private boolean goldenBough;
    private boolean eurydice;
    private String entrance;

    public Orpheus() {
        this.sword = false;
        this.coin = false;
        this.mirror = false;
        this.torch = false;
        this.lyre = false;
        this.goldenBough = false;
        this.eurydice = false;
    }

    public void setSword(boolean sword) { this.sword = sword; }
    public void setTorch(boolean torch) { this.torch = torch; }
    public void setCoin(boolean coin) { this.coin = coin; }
    public void setMirror(boolean mirror) { this.mirror = mirror; }
    public void setLyre(boolean lyre) { this.lyre = lyre; }
    public void setGoldenBough(boolean bough) { this.goldenBough = bough; }
    public void setEntrance(String entrance) {this.entrance = entrance;}
    public void setEurydice(boolean eurydice) { this.eurydice = eurydice; }

    public String getEntrance() {return this.entrance;}
    public boolean getGoldenBough() {return this.goldenBough;}
    public boolean hasCoin() {return this.coin;}
    public boolean hasMirror() {return this.mirror;}
    public boolean hasTorch() {return this.torch;}
    public boolean hasLyre() {return this.lyre;}
    public boolean hasSword() {return this.sword;}
    public boolean hasEurydice() {return this.eurydice;}
}
