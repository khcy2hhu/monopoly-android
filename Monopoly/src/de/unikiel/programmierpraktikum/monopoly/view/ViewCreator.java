package de.unikiel.programmierpraktikum.monopoly.view;

import java.text.DecimalFormat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import de.unikiel.programmierpraktikum.monopoly.R;
import de.unikiel.programmierpraktikum.monopoly.model.BuyableSpace;
import de.unikiel.programmierpraktikum.monopoly.model.ChanceChanceSpace;
import de.unikiel.programmierpraktikum.monopoly.model.ChanceSpace;
import de.unikiel.programmierpraktikum.monopoly.model.CommunityChanceSpace;
import de.unikiel.programmierpraktikum.monopoly.model.FreeParkingSpace;
import de.unikiel.programmierpraktikum.monopoly.model.GoSpace;
import de.unikiel.programmierpraktikum.monopoly.model.GoToJailSpace;
import de.unikiel.programmierpraktikum.monopoly.model.JailSpace;
import de.unikiel.programmierpraktikum.monopoly.model.PaySpace;
import de.unikiel.programmierpraktikum.monopoly.model.Space;
import de.unikiel.programmierpraktikum.monopoly.model.StationSpace;
import de.unikiel.programmierpraktikum.monopoly.model.StreetSpace;
import de.unikiel.programmierpraktikum.monopoly.model.UtilitySpace;
import de.unikiel.programmierpraktikum.monopoly.utilities.Utilities;

/**
 * @author johan_000 Generiert Views aus Spielobjekten
 */
public class ViewCreator {
	private LayoutInflater inflater;

	public ViewCreator(Activity activity) {
		this.inflater = activity.getLayoutInflater();
	}

	public void refreshSpaceView(Space space, View spaceView) {
		DecimalFormat format = Utilities.moneyFormat();
		if (space instanceof GoSpace) {

		} else if (space instanceof ChanceSpace) {
			if (space instanceof ChanceChanceSpace) {

			} else if (space instanceof CommunityChanceSpace) {

			}
		} else if (space instanceof FreeParkingSpace) {

		} else if (space instanceof GoToJailSpace) {

		} else if (space instanceof JailSpace) {

		} else if (space instanceof PaySpace) {
			PaySpace pay = (PaySpace) space;

			TextView name = (TextView) spaceView.findViewById(R.id.txtName);
			name.setText(pay.getName());

			TextView price = (TextView) spaceView.findViewById(R.id.txtPrice);
			price.setText(format.format(pay.getAmount()));
		} else if (space instanceof StationSpace) {
			StationSpace station = (StationSpace) space;

			TextView name = (TextView) spaceView.findViewById(R.id.txtName);
			name.setText(station.getName());

			TextView price = (TextView) spaceView.findViewById(R.id.txtPrice);
			price.setText(format.format(station.getPurchasePrice()));
			
			setBuyableSpaceOwnerImage((BuyableSpace) space, spaceView);
		} else if (space instanceof UtilitySpace) {
			UtilitySpace utility = (UtilitySpace) space;

			TextView name = (TextView) spaceView.findViewById(R.id.txtName);
			name.setText(utility.getName());

			TextView price = (TextView) spaceView.findViewById(R.id.txtPrice);
			price.setText(format.format(utility.getPurchasePrice()));
			
			setBuyableSpaceOwnerImage((BuyableSpace) space, spaceView);
		} else if (space instanceof StreetSpace) {
			StreetSpace street = (StreetSpace) space;

			TextView name = (TextView) spaceView.findViewById(R.id.txtName);
			name.setText(street.getName());

			TextView price = (TextView) spaceView.findViewById(R.id.txtPrice);
			price.setText(format.format(street.getPurchasePrice()));

			View category = spaceView.findViewById(R.id.category);
			category.setBackgroundResource(Utilities.getCategoryColor(street
					.getCategory()));

			setBuyableSpaceOwnerImage((BuyableSpace) space, spaceView);
		}
	}

	public View createSpaceView(Space space, ViewGroup container) {
		View spaceView = null;
		if (space instanceof GoSpace) {
			spaceView = inflater.inflate(R.layout.layout_go_space, container,
					false);
		} else if (space instanceof ChanceSpace) {
			if (space instanceof ChanceChanceSpace) {
				spaceView = inflater.inflate(
						R.layout.layout_chance_chance_space, container, false);
			} else if (space instanceof CommunityChanceSpace) {
				spaceView = inflater.inflate(
						R.layout.layout_community_chance_space, container,
						false);
			}
		} else if (space instanceof FreeParkingSpace) {
			spaceView = inflater.inflate(R.layout.layout_free_parking_space,
					container, false);
		} else if (space instanceof GoToJailSpace) {
			spaceView = inflater.inflate(R.layout.layout_go_to_jail_space,
					container, false);
		} else if (space instanceof JailSpace) {
			spaceView = inflater.inflate(R.layout.layout_jail_space, container,
					false);
		} else if (space instanceof PaySpace) {
			spaceView = inflater.inflate(R.layout.layout_pay_space, container,
					false);
		} else if (space instanceof StationSpace) {
			spaceView = inflater.inflate(R.layout.layout_station_space,
					container, false);
		} else if (space instanceof UtilitySpace) {
			spaceView = inflater.inflate(R.layout.layout_utility_space,
					container, false);
		} else if (space instanceof StreetSpace) {
			spaceView = inflater.inflate(R.layout.layout_street_space,
					container, false);
		}
		refreshSpaceView(space, spaceView);
		return spaceView;
	}
	
	private void setBuyableSpaceOwnerImage(BuyableSpace space, View spaceView) {
		ImageView owner = (ImageView) spaceView.findViewById(R.id.owner);
		ImageView ownerBg = (ImageView) spaceView.findViewById(R.id.owner_bg);
		if (space.getOwner() != null) {
			owner.setImageResource(Utilities.getPegDrawable(space.getOwner()
					.getPeg()));
			ownerBg.setImageResource(Utilities.getCircleDrawable(space.getOwner().getIndex()));
		}
	}
}
