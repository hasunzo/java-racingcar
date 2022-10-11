package racingcar;

import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarErrorCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    void 자동차_생성_성공() {
        RacingCars racingCars = RacingCars.create(new String[]{"test1", "test2", "test3"});
        assertThat(racingCars).isEqualTo(
                RacingCars.create(new String[]{"test1", "test2", "test3"}));
    }

    @Test
    void 자동차_수_음수_실패() {
        Assertions.assertThatThrownBy(() -> RacingCars.create(new String[]{}))
                .isInstanceOf(CustomException.class)
                .hasMessage(RacingCarErrorCode.CAR_NUMBER_BAD_REQUEST.getMessage());
    }

    @Test
    void 랜덤값이_4이하일때_움직이지않는다() {
        RacingCars racingCars = RacingCars.create(new String[]{"test1", "test2", "test3"});
        racingCars.moving(() -> 3);
        List<Car> result = racingCars.copy();
        assertThat(result).extracting("location").containsOnly(0);
    }
}
