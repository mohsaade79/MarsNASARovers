import org.alaf.exceptions.IllegalStateException;
import org.alaf.exceptions.InvalidCommandException;
import org.alaf.exceptions.InvalidDirectionException;
import org.alaf.model.Direction;
import org.alaf.model.Position;
import org.alaf.model.Rover;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRover {
    private Direction direction;
    private Position position;
    private Rover rover;
    @Before
    public void init() throws IllegalStateException, InvalidDirectionException {
      direction=  Direction.N;
      position=EasyMock.createMock(Position.class);
      rover=new Rover(0,0,'N',"");
    }
    @Test
    public void testValidMove() throws IllegalStateException, InvalidCommandException {
        rover.setCommands("RMM");
        rover.startMove(5,5);
        Assert.assertEquals(rover.getCurrentPosition().getX(),2);
    }

    @Test(expected = IllegalStateException.class)
    public void testInValidMove() throws IllegalStateException, InvalidCommandException {
        rover.setCommands("RMMMMMM");
        rover.startMove(5,5);
        Assert.assertEquals(rover.getCurrentPosition().getX(),6);
    }
}
