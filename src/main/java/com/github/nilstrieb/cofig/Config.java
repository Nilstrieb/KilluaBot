package com.github.nilstrieb.cofig;

import com.github.nilstrieb.util.trivia.TriviaQuestionData;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Config {
    public static String TOKEN;
    public static String PREFIX;
    public static String JSON_PATH;

    public static final String NORMAL_PREFIX = "kil ";
    public static final String L_PREFIX = "k ";

    public static final String VERSION = "1.0.1";

    public static final Color DEFAULT_COLOR = new Color(229, 201, 255);

    public static final long THIS_ID = 801015254023798825L;
    public static final long NILS_ID = 414755070161453076L;
    public static final long YUKI_ID = 265849018662387712L;
    public static final long KUKUROO_MOUNTAIN_ID = 799696420386504795L;
    public static final long TRIVIA_APPROVAL_CHANNEL_ID = 802244298774413312L;

    private static final String JSON_PATH_INTELLIJ = "trivia_questions.json";

    private static JDA jda;

    public static void setJda(JDA jda) {
        Config.jda = jda;
    }

    public static EmbedBuilder getDefaultEmbed() {
        User killua = jda.getUserById(THIS_ID);
        if (killua == null) {
            killua = jda.retrieveUserById(THIS_ID).complete();
        }

        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Config.DEFAULT_COLOR)
                .setThumbnail(killua.getAvatarUrl())
                .setFooter("KilluaBot");
        return builder;
    }

    /**
     * 0 = normal
     * 1 = test
     */
    public static void init(int level) {
        switch (level) {
            case 0 -> {
                PREFIX = NORMAL_PREFIX;
                TOKEN = Secrets.NORMAL_TOKEN;
                try {
                    JSON_PATH = new File(TriviaQuestionData.class.getProtectionDomain().getCodeSource()
                            .getLocation().toURI()).getPath().replaceAll("(.*\\\\).*?\\.jar", "$1") + "trivia_questions.json";
                } catch (URISyntaxException e) {
                    throw new RuntimeException("Trivia questions not found", e);
                }
            }
            case 1 -> {
                PREFIX = L_PREFIX;
                TOKEN = Secrets.L_TOKEN;
                JSON_PATH = JSON_PATH_INTELLIJ;
            }
        }
    }
}
