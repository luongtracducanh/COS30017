1. Adjust the 2 text labels on the top:
- Declared attributes: textColor, textSize
2. Change layout to make text labels appear at the center (with the image):
- Component Tree/LinearLayout:
    - layout_gravity: center
- Component Tree/ImageView:
    - adjustViewBounds: true
    - scaleType: centerInside
