package net.barakiroth.measureutils.length;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MeterTest {
	
	@DisplayName("Create one meter using the Meter subclass and test that its size is one")
	@Test
	public void create_one_meter_using_the_Meter_subclass_and_test_that_its_size_is_one() {

		final Meter oneMeter = Meter.of(1.0);
		final double size = oneMeter.getSize();

		assertThat(size, is(1.0));
	}
	
	@DisplayName("Create one inch and assure it is 2.54 cm")
	@Test
	public void create_one_inch_and_assure_it_is_2_54_cm() {

		final Inch  oneInch = Inch.of(1.0);
		final Meter someMeters = Meter.copyOf(oneInch);
		final double sizeOfSomeMeters = someMeters.getSize();

		assertThat(sizeOfSomeMeters, closeTo(2.54E-2, 4.0E-18));
	}
	
	@DisplayName("Create and add two meters")
	@Test
	public void create_and_add_two_meters() {

		final double size1 = 3.14;
		final double size2 = 2.18;
		final Meter meter1 = Meter.of(size1);
		final Meter meter2 = Meter.of(size2);
		final Meter sum = meter1.plus(meter2);

		assertThat(size1 + size2, closeTo(sum.getSize(), 4.0E-18));
	}
	
	@DisplayName("Add an Inch and a Meter instance and verify the meter")
	@Test
	public void add_an_inch_and_a_meter_instance_and_verify_the_meter() {

		final double size1 = 1.0;
		final double size2 = 1.0;
		final Inch oneInch = Inch.of(size1);
		final Meter oneMeter = Meter.of(size2);
		final Meter sumMeter = oneMeter.plus(oneInch);

		assertThat(1.0254, closeTo(sumMeter.getSize(), 4.0E-18));
	}
}