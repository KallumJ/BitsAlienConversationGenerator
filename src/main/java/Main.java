import actions.AdvanceAndRemember;
import actions.AdvanceConversation;
import actions.PayAndAdvance;
import actions.RememberFromChat;
import conversationElements.Conversation;
import conversationElements.ConvoNode;
import conversationElements.Response;

public class Main {
    public static void main(String[] args) {
        Response response1 = new Response("Hi! My name is %!player_name%", new AdvanceAndRemember("%!player_name%", "player_name"), 1);
        Response response2 = new Response("Nice to meet you! My name is [ENTER IN CHAT]", new RememberFromChat("player_name"), 1);
        Response response3 = new Response("Hello! My name is %!player_name%, but you can call me [ENTER IN CHAT]", new RememberFromChat("player_name"), 1);
        Response response4 = new Response("I'd rather not say", new AdvanceConversation(), 2);
        ConvoNode node = new ConvoNode(new String[]{"Hello there! What's your name?"}, new Response[]{response1, response2, response3, response4});

        ConvoNode node2 = new ConvoNode(new String[]{"Nice to meet you %player_name%!"}, new Response[]{});
        ConvoNode node3 = new ConvoNode(new String[]{"That's okay."}, new Response[]{});

        Response response5 = new Response("I've got one for you right here", new PayAndAdvance("portable_reactor"), 3);
        Response response6 = new Response("Sorry, I cant help you with that", new AdvanceConversation(), 4);
        ConvoNode node4 = new ConvoNode(new String[]{"Can you get me one of those Portable Reactors?"}, new Response[]{response5, response6});

        ConvoNode node5 = new ConvoNode(new String[]{"Thanks a lot!"}, new Response[]{});
        ConvoNode node6 = new ConvoNode(new String[]{"That's okay."}, new Response[]{});

        Conversation conversation = new Conversation(new ConvoNode[]{node, node2, node3, node4, node5, node6});

        System.out.println(conversation.getJsonString());


    }
}
