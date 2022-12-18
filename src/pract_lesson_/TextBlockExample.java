package pract_lesson_;

public class TextBlockExample {


    //Allow to avoid using tabs, new line and etc. special characters, instead print string as you see it

    public void printTextBlock(){
        String textBlock = """
                Print bulleted text: 
                    \u2022 Bullet one
                        \u2022 Bullet two
                    
                    \u2022 New Bullet on new line""";
        System.out.println(textBlock);
    }
}
