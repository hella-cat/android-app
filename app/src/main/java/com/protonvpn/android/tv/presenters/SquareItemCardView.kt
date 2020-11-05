/*
 * Copyright (c) 2020 Proton Technologies AG
 *
 * This file is part of ProtonVPN.
 *
 * ProtonVPN is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ProtonVPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ProtonVPN.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.protonvpn.android.tv.presenters

import android.content.Context
import android.view.LayoutInflater
import androidx.leanback.widget.BaseCardView
import com.protonvpn.android.R
import com.protonvpn.android.databinding.TvItemGridBinding
import com.protonvpn.android.tv.models.Card
import com.protonvpn.android.tv.models.DetailedIconCard

class SquareItemCardView(context: Context?) : BaseCardView(context, null, R.style.DefaultCardTheme) {

    val binding: TvItemGridBinding = TvItemGridBinding.inflate(LayoutInflater.from(getContext()), this, true)

    fun updateUi(card: Card) = with(binding) {
        textTitle.text = card.title
        imageIcon.setImageResource(card.image)
        if (card is DetailedIconCard) {
            textDescription.text = card.description
            textSubDescription.text = card.subDescription
            imageBackground.setImageResource(card.backgroundImage.resId)
            imageBackground.alpha = card.backgroundImage.opacity
        }
    }
}
