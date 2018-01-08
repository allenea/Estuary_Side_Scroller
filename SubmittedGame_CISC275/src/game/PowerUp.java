package game;

/**
 * @author ericallen
 *
 */
public class PowerUp extends NPC {

	/**
	 * Questions
	 * Easily formatted to change/input your own questions
	 */
	private static final String[] questions = {
			// Question 1
			"What animal has valuable blue blood?",
			// Question 2
			"True or false: Humans are a threat to estuaries.",
			// Question 3
			"Estuaries contain a mix of fresh and ________ water",
			// Question 4
			"This small bird feeds on horseshoe crab eggs",
			// Question 5
			"The biotic community and its abiotic environment",
			// Question 6
			"A partially enclosed body of water where two different bodies of water meet and mix",
			// Question 7
			"The arrangement of organisms detailing the order in which things are produced/consumed.",
			// Question 8
			"Organism that manufactures its own food energy by photosynthesis. Green plants and some bacteria are ____________.",
			// Question 9
			"An animal that hunts, kills, and eats other animals.",
			// Question 10
			"An animal that is hunted, killed and eaten by other animals. ",
			// Question 11
			"Microscopic photosynthesizing organisms that drift with the currents; microalgae including diatoms and dinoflagellates. ",
			// Question 12
			"process by which plants, using chlorophyll and/or other pigments, manufacture food energy (glucose) from sunlight & Carbon Dioxide (CO2), generating Oxygen (O2) as a byproduct. ",
			// Question 13
			"An inherited change in a living thing that helps it survive better in its environment. ",
			// Question 14
			" When an animal ________, they travel a long-distance, to a find a new habitat temporarily, usually on a seasonal basis.  ",
			// Question 15
			"The particular part of the environment where a plant or animal naturally lives. ",
			// Question 16
			"Structure that demonstrates the movement of food energy through an ecosytem. Producers (plants) serve as the foundation level and an apex consumer is at the top level.",
			// Question 17
			"A network of interacting food chains. ",
			// Question 18
			"True or False: A microorganism that breaks down dead tissue and returns the nutrients to the ecosystem is called a Decomposer",
			// Question 19
			"Organism that feeds upon something else.",
			// Question 20
			"Level within a food pyramid demonstrating an organism's place in the feeding order within an ecosystem. "

	};

	/**
	 * Answer Choices
	 */
	private static final String[] answers = {
			// Answer 1
			"horseshoe crab",
			// Answer 2
			"true",
			// Answer 3
			"salt",
			// Answer 4
			"red knot",
			// Answer 5
			"ecosystem",
			// Answer 6
			"estuary",
			// Answer 7
			"food chain",
			// Answer 8
			"producer",
			// Answer 9
			"predator",
			// Answer 10
			"prey",
			// Answer 11
			"phytoplankton",
			// Answer 12
			"photosynthesis",
			// Answer 13
			"adaptation",
			// Answer 14
			"migrates",
			// Answer 15
			"habitat",
			// Answer 16
			"food pyramid",
			// Answer 17
			"food web",
			// Answer 18
			"true",
			// Answer 19
			"consumer",
			// Answer 20
			"trophic level" };

	/**
	 * Default Constructor
	 * Value for correct is 300
	 */
	public PowerUp() {
		value = 300;
	}
	/*
	 * @see game.NPC#getValue() get value
	 */

	public int getValue() {
		return value;
	}

	/**
	 * @return String question and answers
	 */
	public static String[] getQuestionAndAnswer() {
		int i = (int) (Math.random() * questions.length);
		return new String[] { questions[i], answers[i] };
	}
}
