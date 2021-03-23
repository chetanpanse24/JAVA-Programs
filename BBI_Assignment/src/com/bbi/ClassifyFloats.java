package com.bbi;

import java.util.*;
import java.util.Map.Entry;

public class ClassifyFloats {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String inputString;
		inputString = scan.next();
		String[] inputstr = inputString.split(",");
		float input[] = new float[inputstr.length];

		for (int i = 0; i < input.length; i++) {
			input[i] = Float.valueOf(inputstr[i]);
		}
		Map<Float, List<Float>> floatInterval = new LinkedHashMap<>();
		Float baseFloat = 0.2F;
		int minIntervalValuesCount = Integer.MAX_VALUE;
		for (Float floatValue : input) {
			Float intervalkey = (float) (baseFloat + ((int) Math.floor(floatValue / baseFloat)) * baseFloat);
			List<Float> intervalValues = floatInterval.get(intervalkey);
			if (intervalValues != null) {
				intervalValues.add(floatValue);
				floatInterval.put(intervalkey, intervalValues);
			} else {
				intervalValues = new ArrayList<>();
				intervalValues.add(floatValue);
				floatInterval.put(intervalkey, intervalValues);
			}
		}
		for (Entry<Float, List<Float>> e : floatInterval.entrySet()) {
			if (e.getValue().size() < minIntervalValuesCount) {
				minIntervalValuesCount = e.getValue().size();
			}
		}
		for (Entry<Float, List<Float>> e : floatInterval.entrySet()) {

			for (float fresult : e.getValue().subList(0, minIntervalValuesCount)) {
				System.out.print(fresult + ",");
			}

		}
		scan.close();
	}
}