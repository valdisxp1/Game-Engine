package gameengine.demos

import gameengine._
import gameengine.styles.{ImperativeControlStyle, Game, EventInputStyle}

object Demo extends Game with EventInputStyle with ImperativeControlStyle {

	val width = 640
	val height = 480
	val title = "Hello, World!"

	var angle = 0.0
	val angleDelta = math.Pi / 180

	override def update(in: Input) = {
		angle += angleDelta
		Seq()
	}
	override def render(out: Output) {
		import out._
		withScaling(width, height) {
			drawFilledRect(Color.black)
		}
		withTranslation(width / 2, height / 2) {
			withRotation(angle) {
				withScaling(50, 50) {
					withTranslation(-0.5, -0.5) {
						drawFilledRect(Color.red)
					}
				}
			}
		}
	}

	override val on: PartialFunction[InputEvent, Unit] = {
		case CloseRequestedEvent => quit()
	}
}