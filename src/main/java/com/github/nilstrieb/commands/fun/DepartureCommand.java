package com.github.nilstrieb.commands.fun;

import com.github.nilstrieb.cofig.Config;
import com.github.nilstrieb.core.command.Command;
import com.github.nilstrieb.util.DepartureSong;
import net.dv8tion.jda.api.EmbedBuilder;

public class DepartureCommand extends Command {
    public DepartureCommand() {
        super("departure", "Returns the lyrics of the Hunter x Hunter Opening Song, Departure");
    }

    @Override
    public void called(String args) {

        final EmbedBuilder latinBuilder = Config.getDefaultEmbed();
        latinBuilder.setTitle("DEPARTURE - GALNERYUS")
                .addField("Youtube Link: ", "[Here](" + DepartureSong.DEPARTURE_YOUTUBE_LINK + ")", false)
                .addField("Spotify Link: ", "[Here](" + DepartureSong.DEPARTURE_SPOTIFY_LINK + ")", false)
                .addField("LYRICS (Romanized)", "", false);

        final EmbedBuilder japaneseBuilder = Config.getDefaultEmbed();
        japaneseBuilder.setTitle("DEPARTURE - GALNERYUS")
                .addField("Youtube Link: ", "[Here](" + DepartureSong.DEPARTURE_YOUTUBE_LINK + ")", false)
                .addField("Spotify Link: ", "[Here](" + DepartureSong.DEPARTURE_SPOTIFY_LINK + ")", false)
                .addField("LYRICS (Japanese)", "", false);


        for (int i = 0; i < DepartureSong.LYRICS_LATIN.length; i++) {
            latinBuilder.addField("", DepartureSong.LYRICS_LATIN[i], false);
        }

        for (int i = 0; i < DepartureSong.LYRICS_JAPANESE.length; i++) {
            japaneseBuilder.addField("", DepartureSong.LYRICS_JAPANESE[i], false);
        }

        reply("\uD83C\uDD70", "\uD83C\uDE35", latinBuilder.build(), japaneseBuilder.build());
    }
}
