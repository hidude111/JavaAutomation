package Tests;

import BaseClasses.DBBaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DatabaseTests extends DBBaseTest {

    @Test
    public void GetSkillsWhoseFirstLetterStartsWithA() throws SQLException{
        //Write the query
        List<String> skillNames = new ArrayList<>();
        String query = "Select * From ff14skill_attributes " +
                "WHERE action_name LIKE 'A%' ";
        statement = connection.prepareStatement(query);
        //Time to Execute query
        resultSet = statement.executeQuery();
        while(resultSet.next()) {
            skillNames.add(resultSet.getString("action_name"));
        }
        Assertions.assertTrue(skillNames.contains("Abyssal Drain"));
        Assertions.assertTrue(skillNames.contains("Aeolian Edge"));
        Assertions.assertTrue(skillNames.contains("Assassinate"));
        Assertions.assertTrue(skillNames.contains("Armor Crush"));

    }

}
