import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public abstract class ChessPiece implements Serializable
{
	private boolean isWhite;
	
	private Location loc;
	
	public ChessPiece(boolean isWhite, Location loc)
	{
		this.isWhite = isWhite;
		this.loc = loc;
	}
	
	public void setLocation(Location loc)
	{
		this.loc = loc;
	}
	
	public Location getLocation()
	{
		return loc;
	}
	
	public boolean getColor()
	{
		return isWhite;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract ArrayList<Location> getMoves(BoardState board);
	
	public abstract void moveTo(Location moveLoc);
	
	public static ChessPiece clone(ChessPiece dolly)
	{
		if(dolly instanceof King)
		{
			King piece = new King(dolly.getColor(), dolly.getLocation());
			piece.setHasMoved(((King)dolly).getHasMoved());
			piece.setIsChecked(((King)dolly).isChecked());
			return piece;
		}
		else if(dolly instanceof Queen)
			return new Queen(dolly.getColor(), dolly.getLocation());
		else if(dolly instanceof Pawn)
		{
			Pawn piece = new Pawn(dolly.getColor(), dolly.getLocation());
			piece.setDoubleMove(((Pawn)dolly).getDoubleMove());
			return piece;
		}
		else if(dolly instanceof Rook)
		{
			Rook piece = new Rook(dolly.getColor(), dolly.getLocation());
			piece.setHasMoved(((Rook)dolly).getHasMoved());
			return piece;
		}
		else if(dolly instanceof Bishop)
			return new Bishop(dolly.getColor(), dolly.getLocation());
		else if(dolly instanceof Knight)
			return new Knight(dolly.getColor(), dolly.getLocation());
		else
			return null;
	}
	public String toString()
	{
		if(isWhite)
			return "White";
		else
			return "Black";
	}
}
