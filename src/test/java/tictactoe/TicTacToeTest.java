package tictactoe;

import org.junit.Before;
import org.junit.Test;
import tictactoe.exception.InvalidGridSizeException;
import tictactoe.exception.InvalidPositionException;
import tictactoe.exception.SpotUnavailableException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe(3);
    }

    @Test
    public void givenAnInvalidGridSize_whenNewTicTacToe_thenInvalidGridSizeExceptionIsThrown() {
        assertThatThrownBy(
                () -> new TicTacToe(2)
        ).isInstanceOf(InvalidGridSizeException.class);
    }

    @Test
    public void givenAColumnIsOutsideOfBoard_whenPlay_thenRuntimeExceptionIsThrown() {
        assertThatThrownBy(
                () -> ticTacToe.play(2, 5)
        ).isInstanceOf(InvalidPositionException.class);
    }

    @Test
    public void givenAPlay_whenSpotIsOccupied_thenRuntimeExceptionIsThrown() {
        ticTacToe.play(2, 2);

        assertThatThrownBy(
                () -> ticTacToe.play(2, 2)
        ).isInstanceOf(SpotUnavailableException.class);
    }

    @Test
    public void givenFirstTurn_whenNextPlayer_thenItShouldBePlayerX() {
        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

    @Test
    public void givenSecondTurn_whenNextPlayer_thenItShouldBePlayerY() {
        ticTacToe.play(2, 2); // X

        assertThat(ticTacToe.nextPlayer()).isEqualTo('O');
    }

    @Test
    public void givenSecondRound_whenNextPlayer_thenItShouldBePlayerX() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 2); // O

        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

}
