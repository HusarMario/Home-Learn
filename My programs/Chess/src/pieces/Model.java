package pieces;

import org.jetbrains.annotations.NotNull;
import player.PlayerColor;
import tvary.Kruh;
import tvary.Obdlznik;

public class Model {
    private final Kruh base = new Kruh();
    private final Obdlznik layer1 = new Obdlznik();
    private final Obdlznik layer2 = new Obdlznik();
    private final Obdlznik layer3 = new Obdlznik();

    public Model(PieceType type, PlayerColor color) {
        this.createModel(type, color.getColor());
    }

    public void center(int x, int y) {
        this.base.posunVodorovne(x+15);
        this.base.posunZvisle(y+15);
        this.layer1.posunVodorovne(x+15);
        this.layer1.posunZvisle(y+15);
        this.layer2.posunVodorovne(x+15);
        this.layer2.posunZvisle(y+15);
        this.layer3.posunVodorovne(x+15);
        this.layer3.posunZvisle(y+15);
    }

    public void show() {
        this.base.zobraz();
        this.layer1.zobraz();
        this.layer2.zobraz();
        this.layer3.zobraz();
    }

    public void hide() {
        this.base.skry();
        this.layer1.skry();
        this.layer2.skry();
        this.layer3.skry();
    }

    private void createModel(PieceType type, String color) {
        switch (type) {
            case PAWN -> {
                base.zmenPriemer(20);
                base.zmenFarbu(color);
                layer1.zmenStrany(0,0);
                layer1.zmenFarbu(color);
                layer2.zmenStrany(0,0);
                layer2.zmenFarbu(color);
                layer3.zmenStrany(0,0);
                layer3.zmenFarbu(color);
            }
            case ROOK -> {
                base.zmenPriemer(0);
                base.zmenFarbu(color);
                layer1.zmenStrany(20,20);
                layer1.zmenFarbu(color);
                layer2.zmenStrany(0,0);
                layer2.zmenFarbu(color);
                layer3.zmenStrany(0,0);
                layer3.zmenFarbu(color);
            }
            case KNIGHT -> {
                base.zmenPriemer(10);
                base.zmenFarbu(color);
                base.posunVodorovne(5);
                layer1.zmenStrany(20,10);
                layer1.zmenFarbu(color);
                layer1.posunZvisle(10);
                layer2.zmenStrany(0,0);
                layer2.zmenFarbu(color);
                layer3.zmenStrany(0,0);
                layer3.zmenFarbu(color);
            }
            case BISHOP -> {
                base.zmenPriemer(0);
                base.zmenFarbu(color);
                base.posunVodorovne(5);
                base.posunZvisle(3);
                layer1.zmenStrany(20,10);
                layer1.zmenFarbu(color);
                layer1.posunZvisle(10);
                layer2.zmenStrany(2,20);
                layer2.zmenFarbu(color);
                layer2.posunVodorovne(9);
                layer2.posunZvisle(-5);
                layer3.zmenStrany(20,2);
                layer3.zmenFarbu(color);
            }
            case QUEEN -> {
                base.zmenPriemer(20);
                base.zmenFarbu(color);
                layer1.zmenStrany(0,0);
                layer1.zmenFarbu(color);
                layer2.zmenStrany(2,20);
                layer2.zmenFarbu("black");
                layer2.posunVodorovne(9);
                layer3.zmenStrany(20,2);
                layer3.zmenFarbu("black");
                layer3.posunZvisle(9);
            }
            case KING -> {
                base.zmenPriemer(20);
                base.zmenFarbu(color);
                layer1.zmenStrany(20,20);
                layer1.zmenFarbu(color);
                layer2.zmenStrany(2,20);
                layer2.zmenFarbu("black");
                layer2.posunVodorovne(9);
                layer3.zmenStrany(20,2);
                layer3.zmenFarbu("black");
                layer3.posunZvisle(9);
            }

        }
    }
}
