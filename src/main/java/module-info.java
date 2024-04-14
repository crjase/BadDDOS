module me.jason.badddos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires jdk.compiler;

    opens me.jason.badddos to javafx.fxml;
    exports me.jason.badddos;
    exports me.jason.badddos.skins;
    opens me.jason.badddos.skins to javafx.fxml;
}