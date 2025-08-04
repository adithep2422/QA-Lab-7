package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import sqa.main.CountWordClumps;

class CountWordTesting {

	CountWordClumps test;

	@BeforeEach
	void setup() {
		test = new CountWordClumps();
	}

	@ParameterizedTest
	@MethodSource("arraysForClumpCounting")
	void test_Branch_and_Condition_Coverage(int[] nums, int expected) {
		assertEquals(expected, CountWordClumps.countClumps(nums));
	}

	static Stream<Arguments> arraysForClumpCounting() {
		return Stream.of(
			
				Arguments.of(null, 0),
				Arguments.of(new int[] {}, 0),
				Arguments.of(new int[] {1}, 0),
				Arguments.of(new int[] {1, 1}, 1),
				Arguments.of(new int[] {1, 2}, 0),
				Arguments.of(new int[] {1, 2, 2}, 1)
			
		);
	}
}
