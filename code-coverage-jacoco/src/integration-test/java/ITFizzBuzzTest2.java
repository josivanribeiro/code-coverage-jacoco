import test.java.FizzBuzz;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;


@RunWith(Arquillian.class)
public class ITFizzBuzzTest2 {

    private FizzBuzz fizzBuzz;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass (FizzBuzz.class)
            .addClass (ITFizzBuzzTest2.class);           
    }
    
    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void getFizzBuzzWord_NumberIsMultipleOfThree_ShouldReturnFizz() {
        assertThat(fizzBuzz.getFizzBuzzWord(3), is("Fizz"));
    }    

    @Test
    public void getFizzBuzzWord_NumberIsNotMultipleOfThreeOrFive_ShouldReturnNull() {
        assertNull(fizzBuzz.getFizzBuzzWord(4));
    }
}
