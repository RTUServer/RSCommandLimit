package com.github.ipecter.rtustudio.commandlimit;

import com.github.ipecter.rtustudio.commandlimit.configuration.LimitConfig;
import com.github.ipecter.rtustudio.commandlimit.commands.Command;
import com.github.ipecter.rtustudio.commandlimit.listeners.PlayerCommandPreprocess;
import com.github.ipecter.rtustudio.commandlimit.listeners.PlayerCommandSend;
import kr.rtuserver.framework.bukkit.api.RSPlugin;
import lombok.Getter;
import org.bukkit.permissions.PermissionDefault;

@Getter
public class CommandLimit extends RSPlugin {

    private LimitConfig limitConfig;

    @Override
    public void enable() {
        registerPermission("cmdlimit.default", PermissionDefault.TRUE);
        registerPermission("cmdlimit.bypass.execute", PermissionDefault.OP);
        registerPermission("cmdlimit.bypass.tabComplete", PermissionDefault.OP);

        limitConfig = new LimitConfig(this);

        registerEvent(new PlayerCommandPreprocess(this));
        registerEvent(new PlayerCommandSend(this));
        registerCommand(new Command(this), true);
    }
}
