package org.examples;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = {
                "C:\\ProjetosBN\\Projetos individuais\\ProjetoGrupo\\ForwardCarFernandaLucas\\src\\test\\java\\resources\\Feature.feature",
        },
        glue = {
                "org/examples"
        },
        tags = "@CT002"

)

public class Runner {
}
