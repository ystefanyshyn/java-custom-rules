package org.ystefanyshyn.sonar.custom.rules.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * .
 */
public class JacksonJsonIgnoreCheckTest {

    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/JacksonClass.java", new JacksonJsonIgnoreCheck());
    }
}
