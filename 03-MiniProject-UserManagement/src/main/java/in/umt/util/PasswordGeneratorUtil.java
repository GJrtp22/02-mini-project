package in.umt.util;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

@Component
public class PasswordGeneratorUtil {

	public static String generateSecurePassword() {
		CharacterRule lcr = new CharacterRule(EnglishCharacterData.LowerCase);
		lcr.setNumberOfCharacters(2);

		CharacterRule ucr = new CharacterRule(EnglishCharacterData.UpperCase);
		ucr.setNumberOfCharacters(2);

		CharacterRule dr = new CharacterRule(EnglishCharacterData.Digit);
		dr.setNumberOfCharacters(2);

		CharacterRule sr = new CharacterRule(EnglishCharacterData.Special);
		sr.setNumberOfCharacters(2);

		PasswordGenerator passwordGenerator = new PasswordGenerator();

		return passwordGenerator.generatePassword(8, sr, lcr, ucr, dr);

	}
}
