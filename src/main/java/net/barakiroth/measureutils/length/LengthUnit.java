package net.barakiroth.measureutils.length;

import lombok.AccessLevel;
import lombok.Getter;

public enum LengthUnit {
	
	METER(1.0/299792458.0),
	INCH(2.54/(100.0*299792458.0))
;	

	@Getter(AccessLevel.PUBLIC)
	private final double unitSizeInCanonicalLength;
	
	private LengthUnit(final double unitSizeInCanonicalLength) {
		this.unitSizeInCanonicalLength = unitSizeInCanonicalLength;
	}
}