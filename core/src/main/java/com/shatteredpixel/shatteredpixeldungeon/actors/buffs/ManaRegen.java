
/* ######### KarH's new file ######### */

package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

public class ManaRegen extends Buff {
    {
        // 行动前刚好触发回蓝。太善良了。
        actPriority = HERO_PRIO + 1;
    }

    private static final float BASIC_MANA_REGEN = 10f;

    @Override
    public boolean act() {
        if (target.isAlive() && target instanceof Hero) {
            Hero owner = (Hero) target;

            if (owner.mana_cur < owner.mana_max)
                owner.mana_cur += 1;

            // demo - 每10回合回1点
            spend(BASIC_MANA_REGEN);
        }
        // 不知道为什么，还没见过return false的
        return true;
    }
}
