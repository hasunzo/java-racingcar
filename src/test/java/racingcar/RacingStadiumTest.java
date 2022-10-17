package racingcar;

import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarErrorCode;
import racingcar.exception.RacingCarErrorCode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingStadiumTest {
    @Test
    @DisplayName("참여하는 자동차가 하나도 없는 경우 테스트가 실패한다.")
    void carNames_bad_request_false() {
        Assertions.assertThatThrownBy(() -> new RacingStadium(""))
                .isInstanceOf(CustomException.class)
                .hasMessage(CarErrorCode.CAR_NAME_NOT_BLANK.getMessage());
    }

    @Test
    @DisplayName("이동 횟수를 음수로 넘기면 테스트가 실패한다.")
    void moveNumber_negative_false() {
        RacingStadium racingStadium = new RacingStadium("test1,test2,test3");
        Assertions.assertThatThrownBy(() -> racingStadium.race(-1))
                .isInstanceOf(CustomException.class)
                .hasMessage(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST.getMessage());
    }
}
