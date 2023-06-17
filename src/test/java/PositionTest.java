import org.alaf.exceptions.IllegalStateException;
import org.alaf.model.Direction;
import org.alaf.model.Position;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {
    private Position position;
    private Direction direction;
    @Before
    public void init(){
        direction=Direction.N;

    }

    @Test(expected = IllegalStateException.class)
    public void createInValidPosition() throws IllegalStateException {
        position= new Position();
        position.setX(-4);
    }

   @Test
   public void testMove() throws IllegalStateException {
        position= new Position(0,0,direction);
        position.move();
       Assert.assertEquals(position.getY(),1);
   }


}
