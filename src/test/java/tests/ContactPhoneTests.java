package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {


    @Test
    public void testContactPhones() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditFrom = app.contact().infoFromEditFrom(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditFrom)));


    }


    /**
     *метод mergePhones
     * @param contact
     * @return
     * Формируем коллекцию из телефонов.
     *
     * stream, @filter -список в поток после фильтрация потока, нужно выбросить ненужные элементы те которые == "" пустая строка
     * filter - в качестве параметра нужно передать анонимную функцию которая на вход принимает строку "s" и проверяем что строка не равна пустой строке
     * map - Приминяется ко всем элементам потока и вернуть поток состоящий из результатов этой функции, применить нужно метод **cleaned**
     * collect(Collectors.joining) - собрать в качестве параметра передать Коллектор в классе Collectors.joining - который склеивает все элементы потока в одну строку.
     */


    private String mergePhones(ContactData contact) {
     return    Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
           .stream().filter((s) -> !s.equals(""))
             .map(ContactPhoneTests::cleaned)
             .collect(Collectors.joining("\n"));
    }

    /**
     *
     * @param phone
     * @return
     * метод cleaned реализует очистку контакта от символов: пробел,-,()
     */
    public static String  cleaned (String phone){
        return  phone.replaceAll("\\s" , "").replaceAll("[-()]","");
    }
}
