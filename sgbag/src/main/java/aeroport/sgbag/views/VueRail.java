/**
 * 
 */
package aeroport.sgbag.views;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;

import aeroport.sgbag.kernel.Rail;

/**
 * @author Arnaud Lahache
 * 
 */
@NoArgsConstructor
public class VueRail extends VueElem {

	@Getter
	@Setter
	private Rail rail;

	public VueRail(VueHall parent) {
		super(parent);
		this.image = new Image(parent.getDisplay(), "data/img/rail.png");
		
		Rectangle rect = image.getBounds();
		this.width = rect.width;
		this.height = rect.height;
	}

	/**
	 * @see aeroport.sgbag.views.VueElem#updateView()
	 */
	@Override
	public void updateView() {
		this.width = rail.getLength();
	}

	/**
	 * @see aeroport.sgbag.views.VueElem#draw()
	 */
	@Override
	public void draw() {
		GC gc = this.parent.getGcBuffer();

		// We get the size of the original image :
		Rectangle rect = image.getBounds();

		// We create a transform in order to rotate and translate the image :
		Transform trImage = new Transform(parent.getDisplay());
		trImage.translate(this.x, this.y);
		trImage.rotate(this.angle);
		gc.setTransform(trImage);

		// Then we just draw the image on the GC :
		gc.drawImage(this.image, 0, 0, rect.width, rect.height, 0,
				-this.height / 2, this.width, this.height);

		// We no longer need the transform :
		gc.setTransform(null);
		trImage.dispose();
	}

}
