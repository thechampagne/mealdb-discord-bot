package command

import io.github.thexxiv.jda.command.manager.Command
import io.github.thexxiv.mealdb.MealDB
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import java.awt.Color
import java.time.Instant
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import kotlin.random.Random

class Search : Command {
    override fun run(args: List<String>, event: GuildMessageReceivedEvent) {
        val input = args.stream().map { obj: Any -> obj.toString() }.collect(Collectors.joining(" "))
        val user = event.message.author.name
        val icon = event.message.author.avatarUrl
        val bot = event.jda.selfUser.name
        val botIcon = event.jda.selfUser.avatarUrl
        val message = event.channel.sendMessageEmbeds(EmbedBuilder().setDescription("**Loading...** :hourglass:").setColor(Color.decode("#ffac33")).build())
            .delay(3, TimeUnit.SECONDS).complete()
        try {
            if (!indexExists(args, 0)) {
                message.editMessageEmbeds(
                    EmbedBuilder().setDescription("**You have to write a meal name** :warning:").setColor(Color.decode("#ffcc4d")).build()
                ).queue()
            } else {
                val data = MealDB.search(input)
                if (data != null) {
                    val random = Random.nextInt(data.size)
                    val meal = data[random]
                    val r = Random.nextInt(255);
                    val g = Random.nextInt(255);
                    val b = Random.nextInt(255);
                    var str = ""
                    if (meal.strMeal != null) str += "**`Meal:`** **${meal.strMeal}**\n\n"
                    if (meal.idMeal != null) str += "**`Id:`** **${meal.idMeal}**\n\n"
                    if (meal.strDrinkAlternate != null && meal.strDrinkAlternate != "") str += "**`Drink Alternate:`** **${meal.strDrinkAlternate}**\n\n"
                    if (meal.strTags != null && meal.strTags != "") str += "**`Tags:`** **${meal.strTags}**\n\n"
                    if (meal.strCategory != null && meal.strCategory != "") str += "**`Category:`** **${meal.strCategory}**\n\n"
                    if (meal.strArea != null && meal.strArea != "") str += "**`Area:`** **${meal.strArea}**\n\n"
                    if (meal.strInstructions != null && meal.strInstructions != "") str += "**`Instructions:`** **${meal.strInstructions}**\n\n"
                    if (meal.strMealThumb != null && meal.strMealThumb != "") str += "**`Image:`** **${meal.strMealThumb}**\n\n"
                    if (meal.strYoutube != null && meal.strYoutube != "") str += "**`Video:`** **${meal.strYoutube}**\n\n"
                    if (meal.strIngredient1 != null && meal.strIngredient1 != "") str += "**`Ingredient1:`** **${meal.strIngredient1}**\n\n"
                    if (meal.strIngredient2 != null && meal.strIngredient2 != "") str += "**`Ingredient2:`** **${meal.strIngredient2}**\n\n"
                    if (meal.strIngredient3 != null && meal.strIngredient3 != "") str += "**`Ingredient3:`** **${meal.strIngredient3}**\n\n"
                    if (meal.strIngredient4 != null && meal.strIngredient4 != "") str += "**`Ingredient4:`** **${meal.strIngredient4}**\n\n"
                    if (meal.strIngredient5 != null && meal.strIngredient5 != "") str += "**`Ingredient5:`** **${meal.strIngredient5}**\n\n"
                    if (meal.strIngredient6 != null && meal.strIngredient6 != "") str += "**`Ingredient6:`** **${meal.strIngredient6}**\n\n"
                    if (meal.strIngredient7 != null && meal.strIngredient7 != "") str += "**`Ingredient7:`** **${meal.strIngredient7}**\n\n"
                    if (meal.strIngredient8 != null && meal.strIngredient8 != "") str += "**`Ingredient8:`** **${meal.strIngredient8}**\n\n"
                    if (meal.strIngredient9 != null && meal.strIngredient9 != "") str += "**`Ingredient9:`** **${meal.strIngredient9}**\n\n"
                    if (meal.strIngredient10 != null && meal.strIngredient10 != "") str += "**`Ingredient10:`** **${meal.strIngredient10}**\n\n"
                    if (meal.strIngredient11 != null && meal.strIngredient11 != "") str += "**`Ingredient11:`** **${meal.strIngredient11}**\n\n"
                    if (meal.strIngredient12 != null && meal.strIngredient12 != "") str += "**`Ingredient12:`** **${meal.strIngredient12}**\n\n"
                    if (meal.strIngredient13 != null && meal.strIngredient13 != "") str += "**`Ingredient13:`** **${meal.strIngredient13}**\n\n"
                    if (meal.strIngredient14 != null && meal.strIngredient14 != "") str += "**`Ingredient14:`** **${meal.strIngredient14}**\n\n"
                    if (meal.strIngredient15 != null && meal.strIngredient15 != "") str += "**`Ingredient15:`** **${meal.strIngredient15}**\n\n"
                    if (meal.strIngredient16 != null && meal.strIngredient16 != "") str += "**`Ingredient16:`** **${meal.strIngredient16}**\n\n"
                    if (meal.strIngredient17 != null && meal.strIngredient17 != "") str += "**`Ingredient17:`** **${meal.strIngredient17}**\n\n"
                    if (meal.strIngredient18 != null && meal.strIngredient18 != "") str += "**`Ingredient18:`** **${meal.strIngredient18}**\n\n"
                    if (meal.strIngredient19 != null && meal.strIngredient19 != "") str += "**`Ingredient19:`** **${meal.strIngredient19}**\n\n"
                    if (meal.strIngredient20 != null && meal.strIngredient20 != "") str += "**`Ingredient20:`** **${meal.strIngredient20}**\n\n"
                    if (meal.strMeasure1 != null && meal.strMeasure1 != "") str += "**`Measure1:`** **${meal.strMeasure1}**\n\n"
                    if (meal.strMeasure2 != null && meal.strMeasure2 != "") str += "**`Measure2:`** **${meal.strMeasure2}**\n\n"
                    if (meal.strMeasure3 != null && meal.strMeasure3 != "") str += "**`Measure3:`** **${meal.strMeasure3}**\n\n"
                    if (meal.strMeasure4 != null && meal.strMeasure4 != "") str += "**`Measure4:`** **${meal.strMeasure4}**\n\n"
                    if (meal.strMeasure5 != null && meal.strMeasure5 != "") str += "**`Measure5:`** **${meal.strMeasure5}**\n\n"
                    if (meal.strMeasure6 != null && meal.strMeasure6 != "") str += "**`Measure6:`** **${meal.strMeasure6}**\n\n"
                    if (meal.strMeasure7 != null && meal.strMeasure7 != "") str += "**`Measure7:`** **${meal.strMeasure7}**\n\n"
                    if (meal.strMeasure8 != null && meal.strMeasure8 != "") str += "**`Measure8:`** **${meal.strMeasure8}**\n\n"
                    if (meal.strMeasure9 != null && meal.strMeasure9 != "") str += "**`Measure9:`** **${meal.strMeasure9}**\n\n"
                    if (meal.strMeasure10 != null && meal.strMeasure10 != "") str += "**`Measure10:`** **${meal.strMeasure10}**\n\n"
                    if (meal.strMeasure11 != null && meal.strMeasure11 != "") str += "**`Measure11:`** **${meal.strMeasure11}**\n\n"
                    if (meal.strMeasure12 != null && meal.strMeasure12 != "") str += "**`Measure12:`** **${meal.strMeasure12}**\n\n"
                    if (meal.strMeasure13 != null && meal.strMeasure13 != "") str += "**`Measure13:`** **${meal.strMeasure13}**\n\n"
                    if (meal.strMeasure14 != null && meal.strMeasure14 != "") str += "**`Measure14:`** **${meal.strMeasure14}**\n\n"
                    if (meal.strMeasure15 != null && meal.strMeasure15 != "") str += "**`Measure15:`** **${meal.strMeasure15}**\n\n"
                    if (meal.strMeasure16 != null && meal.strMeasure16 != "") str += "**`Measure16:`** **${meal.strMeasure16}**\n\n"
                    if (meal.strMeasure17 != null && meal.strMeasure17 != "") str += "**`Measure17:`** **${meal.strMeasure17}**\n\n"
                    if (meal.strMeasure18 != null && meal.strMeasure18 != "") str += "**`Measure18:`** **${meal.strMeasure18}**\n\n"
                    if (meal.strMeasure19 != null && meal.strMeasure19 != "") str += "**`Measure19:`** **${meal.strMeasure19}**\n\n"
                    if (meal.strMeasure20 != null && meal.strMeasure20 != "") str += "**`Measure20:`** **${meal.strMeasure20}**\n\n"
                    if (meal.strImageSource != null && meal.strImageSource != "") str += "**`Image Source:`** **${meal.strImageSource}**\n\n"
                    if (meal.strSource != null && meal.strSource != "") str += "**`Source:`** **${meal.strSource}**\n\n"
                    if (meal.strCreativeCommonsConfirmed != null && meal.strCreativeCommonsConfirmed != "") str += "**`Creative Commons Confirmed:`** **${meal.strCreativeCommonsConfirmed}**\n\n"
                    if (meal.dateModified != null && meal.dateModified != "") str += "**`Date Modified:`** **${meal.dateModified}**"

                    message.editMessageEmbeds(EmbedBuilder()
                        .setAuthor(bot,null,botIcon)
                        .setDescription(str)
                        .setColor(Color(r,g,b))
                        .setFooter("Requested by $user", icon)
                        .setTimestamp(Instant.now())
                        .build()).queue()
                } else {
                    message.editMessageEmbeds(
                        EmbedBuilder().setDescription("**Something went wrong** :bangbang:").setColor(Color.decode("#be1931")).build()
                    ).queue()
                }
            }
        } catch (ex: Exception) {
            message.editMessageEmbeds(
                EmbedBuilder().setDescription("**Something went wrong** :bangbang:").setColor(Color.decode("#be1931")).build()
            ).queue()
        }
    }

    override fun getCommand(): String {
        return "search"
    }
}

fun indexExists(list: List<String>, index: Int): Boolean {
    return index >= 0 && index < list.size
}