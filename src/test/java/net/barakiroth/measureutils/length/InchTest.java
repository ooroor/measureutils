package net.barakiroth.measureutils.length;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InchTest {
	
	@DisplayName("Create one inch using the Inch subclass and test that its size is one")
	@Test
	public void create_one_inch_using_the_Inch_subclass_and_test_that_its_size_is_one() {

		final Inch oneInch = Inch.of(1.0);
		final double size = oneInch.getSize();

		assertThat(size, is(1.0));
	}
	
	@DisplayName("Create one meter and assure it is 39.37 inches")
	@Test
	public void create_one_meter_and_assure_it_is_39_37_inches() {

		final Meter  oneMeter = Meter.of(1.0);
		final Inch someInches = Inch.copyOf(oneMeter);
		final double sizeOfSomeInches = someInches.getSize();

		assertThat(sizeOfSomeInches, closeTo(39.370078740157474, 4.0E-18));
	}
	
	@DisplayName("Create and add two inches")
	@Test
	public void create_and_add_two_inches() {

		final double size1 = 3.14;
		final double size2 = 2.18;
		final Inch inch1 = Inch.of(size1);
		final Inch inch2 = Inch.of(size2);
		final Inch sum = inch1.plus(inch2);

		assertThat(size1 + size2, closeTo(sum.getSize(), 9.0E-16));
	}
	
	@DisplayName("Add an Inch and a Meter instance and verify the inch")
	@Test
	public void add_an_inch_and_a_meter_instance_and_verify_the_inch() {

		final double size1 = 1.0;
		final double size2 = 1.0;
		final Meter oneMeter = Meter.of(size1);
		final Inch oneInch = Inch.of(size2);
		final Inch sumInch = oneInch.plus(oneMeter);

		assertThat(40.37007874015748, closeTo(sumInch.getSize(), 1.0E-30));
	}
}
