package custom.gui.object;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import custom.gui.util.GuiUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;

public class EGuiField implements EGuiObject {

    public int x, y, width, height, id, maxStringLength;
    public GuiTextField instance;
    public boolean wheel;

    public EGuiField(JsonObject obj) {
        GuiUtil.writeInObject(new Gson().fromJson(obj, this.getClass()), this);
    }

    @Override
    public void draw(int mouseX, int mouseY, float partialTicks) {
        instance.xPosition = x;
        instance.yPosition = y;
        instance.width = width;
        instance.height = height;
        instance.drawTextBox();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public void init() {
        instance = new GuiTextField(id, Minecraft.getMinecraft().fontRendererObj, x, y, width, height);
        instance.setMaxStringLength(maxStringLength);
    }

}
