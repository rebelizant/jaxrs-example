package io.github.rebelizant.jaxrsexample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author rebelizant
 *         Created on 20.04.16
 */
@Configuration
@ComponentScan(basePackages = {
    "io.github.rebelizant.jaxrsexample.persistence",
    "io.github.rebelizant.jaxrsexample.rest"
})
public class SpringConfig {
}
