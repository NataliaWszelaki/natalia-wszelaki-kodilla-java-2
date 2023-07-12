package com.kodilla.stream;

public class StreamMain {

    public static void main(String[] args) {

    }






//        Forum theForum = new Forum();
//
//        Map<Integer, ForumUser> theResultMapOfForumUsers = theForum.getUserList().stream()
//                .filter(forumUser -> forumUser.getUserSex() == 'M')
//                .filter(forumUser -> forumUser.userAge() > 20)
//                .filter(forumUser -> forumUser.getPostsQty() >= 1)
//                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));
//
//        theResultMapOfForumUsers.entrySet().stream()
//        .map(entry -> entry.getKey() + ": " + entry.getValue())
//                .forEach(System.out::println);
//
//    }



//        BookDirectory theBookDirectory = new BookDirectory();
//        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .map(Book::toString)
//                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]
//
//        System.out.println(theResultStringOfBooks);
//
//    }

//        BookDirectory theBookDirectory = new BookDirectory();
//
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]
//
//        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
//        theResultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
//                .forEach(System.out::println);
//    }


//            BookDirectory theBookDirectory = new BookDirectory();
//            List<Book> theResultListOfBooks = theBookDirectory.getList().stream()   // [1]
//                    .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
//                    .collect(Collectors.toList());                                       // [3]
//
//            System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
//            theResultListOfBooks.stream()                                           // [5]
//                    .forEach(System.out::println);
//        }


//        People.getList().stream()
//                .map(String::toUpperCase)                             // [1]
//                .filter(s -> s.length() > 11)                         // [2]
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3]
//                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
//                .forEach(System.out::println);                        // [5]


//        Processor processor = new Processor();
//        processor.execute(() -> System.out.println("This is an example text."));
//
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("Calculating expressions with method references");
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
//
//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//        poemBeautifier.beautify("abc", text -> "ABC" + text + "ABC");
//        poemBeautifier.beautify("table", text -> {
//            return text.toUpperCase();
//        });
//        poemBeautifier.beautify("12345", text -> {
//            return String.valueOf(text.length());
//        });
//        poemBeautifier.beautify("illegal", text -> text.substring(2));
//        poemBeautifier.beautify("noga", text -> String.valueOf(text.hashCode()));
//        poemBeautifier.beautify(" addicted to coffee ", text -> text.trim());
//        poemBeautifier.beautify("addicted to coffee and chocolate", text -> String.valueOf(text.startsWith("addicted")));
//        poemBeautifier.beautify("Hello World!", text -> text.replace("Hello", "Kalimera"));
//
//        System.out.println();
//        System.out.println("Using Stream to generate even numbers from 1 to 20");
//        NumbersGenerator.generateEven(1000);
//}
}