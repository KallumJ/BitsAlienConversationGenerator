import actions.AdvanceAndRemember;
import actions.AdvanceConversation;
import actions.PayAndAdvance;
import actions.RememberFromChat;

public class Main {
    public static void main(String[] args) {
        Response response1 = new Response("Hi! My name is %!player_name%", new AdvanceAndRemember("%!player_name%", "player_name"), 1);
        Response response2 = new Response("Nice to meet you! My name is [ENTER IN CHAT]", new RememberFromChat("player_name"), 1);
        Response response3 = new Response("Hello! My name is %!player_name%, but you can call me [ENTER IN CHAT]", new RememberFromChat("player_name"), 1);
        Response response4 = new Response("I'd rather not say", new AdvanceConversation(), 2);
        Node node = new Node(0, new String[]{"Hello there! What's your name?"}, new Response[]{response1, response2, response3, response4});

        Node node2 = new Node(1, new String[]{"Nice to meet you %player_name%!"}, new Response[]{});
        Node node3 = new Node(2, new String[]{"That's okay."}, new Response[]{});

        Response response5 = new Response("I've got one for you right here", new PayAndAdvance("portable_reactor"), 3);
        Response response6 = new Response("Sorry, I cant help you with that", new AdvanceConversation(), 4);
        Node node4 = new Node(-1, new String[]{"Can you get me one of those Portable Reactors?"}, new Response[]{response5, response6});

        Node node5 = new Node(3, new String[]{"Thanks a lot!"}, new Response[]{});
        Node node6 = new Node(4, new String[]{"That's okay."}, new Response[]{});

        Conversation conversation = new Conversation(new Node[]{node, node2, node3, node4, node5, node6});

        System.out.println(conversation.getJsonString());

    }
}
