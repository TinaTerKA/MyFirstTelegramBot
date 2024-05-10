package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "t.me/May_7_2024_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6452442086:AAFBL_y77xIv-5YBx2jWanxIm1Jx2jhKHqA"; //TODO: добавьте токен бота в кавычках


    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // отобразить начало игры, взломать холодильник
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, java.util.Map.of("Взлом холодильника", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    java.util.Map.of("Взять сосиску! +20 славы", "step_2_btn" ,
                    "Взять рыбу! +20 славы", "step_2_btn",
                    "Скинуть банку с огурцами! +20 славы", "step_2_btn"));
        }
        // взламываем робот-пылесос
        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, java.util.Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    java.util.Map.of("Отправить робот пылесос за едой! +30 славы", "step_4_btn" ,
                            "Покататься на роботе пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робота пылесоса! +30 славы", "step_4_btn"));
        }
        // взламываем камеру  Go-pro
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, java.util.Map.of("Надеть и включить GoPro!", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    java.util.Map.of("Бегать по крышам, снимать на GoPro! +40 славы", "step_6_btn" ,
                            "С GoPro нападать на других котов из засады! +40 славы", "step_6_btn",
                            "С GoPro нападать на собак из засады! +40 славы", "step_6_btn"));
        }
        // взламываем компьютер
        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, java.util.Map.of("Взлом пароля! +50 славы", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    java.util.Map.of("Выйти во двор", "step_8_btn"));
        }
        // хвастаемся дворовым котам
        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}



// sendTextMessageAsync("Привет!");
// sendTextMessageAsync("*я вас всех люблю*"); // для выделения текста жирным
// sendTextMessageAsync("_ты замечательный человек_"); // для наклонного текста
//        if (getMessageText().equals("/start")) {
//                sendTextMessageAsync("Привет!");
//                }
//                if (getMessageText().equals("/bye")) {
//                sendTextMessageAsync("Пока!");
//                }
//                if (getMessageText().contains("Как здоровье?")) {
//                sendTextMessageAsync("Хорошо");
//                }
//                if (getMessageText().contains("картинка")) {
//                sendPhotoMessageAsync("step_8_pic");
//                }
//                if (getMessageText().contains("кот")) {
//                sendPhotoMessageAsync("Выбери номер кота: ",
//                Map.of("кот 1", "cat1", "кот 2", "cat2"));
//                }
//                if (getCallbackQueryButtonKey().equals("cat1")){
//                sendPhotoMessageAsync("step_1_pic");
//                }
//                if (getCallbackQueryButtonKey().equals("cat2")){
//                sendPhotoMessageAsync("step_2_pic");
//                }
//                if (getMessageText().equals("smile")){
//                var message = getLastSentMessage();
//                editTextMessageAsync(message.getMessageId(), message.getText()+" :) ");
//                }