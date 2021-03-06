/**
 * 
 */
package com.hotel.automation.criteria;

import java.util.List;

import com.hotel.automation.model.Floor;
import com.hotel.automation.model.MainCorridor;
import com.hotel.automation.model.SubCorridor;

/**
 * Implementation of a {@link Criteria} to know if the Power consumption within
 * a {@link Floor} is well within the limits.
 * 
 * @author aarishramesh
 *
 */
public class PowerConsumptionCriteria implements Criteria {

	public static final int LIGHTBULB_POWER_RATING = 5;

	public static final int AIRCONDITIONER_POWER_RATING = 10;

	public static final int DECORATIVELIGHTS_POWER_RATING = 5;
	
	@Override
	public boolean criteriaMetFor(Floor floor) {
		return powerConsumptionForFloor(floor) <= getMaxPowerAllowedForFloor(floor);
	}

	/**
	 * Calculates the Maximum Power a Floor could consume at any given point of
	 * time. This implementation may change depending upon the Hotel
	 * requirements.
	 * 
	 * @param floor
	 *            The Floor to check for.
	 * @return Combined value of the Power consumed.
	 */
	private int getMaxPowerAllowedForFloor(Floor floor) {
		List<MainCorridor> mainCorridors = floor.getMainCorridors();
		List<SubCorridor> subCorridors = floor.getSubCorridors();
		return (mainCorridors.size() * 25) + subCorridors.size() * 15;
	}

	/**
	 * Calculates the Electrical power consumed by the equipments found in the
	 * given Floor at this current instant. Which means the equipments which are
	 * not switched on (or running) at this moment are excluded from this
	 * calculation.
	 * 
	 * @param floor
	 *            The Floor to check for.
	 * @return The Total power consumed at this moment.
	 */
	private int powerConsumptionForFloor(Floor floor) {
		return floor.getTotalPowerConsumed();
	}

}
