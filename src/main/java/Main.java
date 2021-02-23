public class Main {
    public static void main(String[] args) {
        Response response1 = new Response("Hi! My name is %!player_name%", Action.ADVANCE_AND_REMEMBER, 1);
        Response response2 = new Response("Nice to meet you! My name is [ENTER IN CHAT]", Action.REMEMBER_FROM_CHAT, 1);
        Response response3 = new Response("Hello! My name is %!player_name%, but you can call me [ENTER IN CHAT]", Action.REMEMBER_FROM_CHAT, 1);
        Response response4 = new Response("I'd rather not say", Action.ADVANCE_CONVERSATION, 2);

        Node node = new Node(0, new String[]{"Hello there! What's your name?"}, new Response[]{response1, response2, response3, response4});

        Conversation conversation = new Conversation(new Node[]{node});

        System.out.println(conversation.getJsonString());

    }
}
