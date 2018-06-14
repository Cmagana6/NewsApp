package com.m00061016.gamenews.Objects;

public class Player {

    private String _id;
    private String name;
    private String biografia;
    private String avatar;
    private String game;
    private int __v;

    public Player(String _id, String name, String biografia, String avatar, String game, int __v) {
        this._id = _id;
        this.name = name;
        this.biografia = biografia;
        this.avatar = avatar;
        this.game = game;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
