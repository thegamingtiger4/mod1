// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustom_modeldroid extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer rightleg;
	private final ModelRenderer bone;
	private final ModelRenderer leftleg;
	private final ModelRenderer bone2;
	private final ModelRenderer chest;
	private final ModelRenderer slants;
	private final ModelRenderer slants2;
	private final ModelRenderer head;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone11;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;

	public Modelcustom_modeldroid() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(45, 14).addBox(-5.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(40, 6).addBox(-5.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, -3.0F);
		rightleg.addChild(bone);
		setRotationAngle(bone, -0.3054F, 0.0F, 0.0F);
		bone.setTextureOffset(42, 29).addBox(-5.0F, -16.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(44, 38).addBox(3.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(16, 40).addBox(3.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, -3.0F);
		leftleg.addChild(bone2);
		setRotationAngle(bone2, -0.3054F, 0.0F, 0.0F);
		bone2.setTextureOffset(24, 42).addBox(3.0F, -16.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(chest);
		chest.setTextureOffset(24, 24).addBox(-5.0F, -17.0F, 1.0F, 10.0F, 3.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(0, 4).addBox(-5.0F, -34.0F, 0.0F, 10.0F, 10.0F, 4.0F, 0.0F, false);
		chest.setTextureOffset(24, 4).addBox(-5.0F, -20.0F, 1.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(0, 18).addBox(-4.0F, -35.0F, 0.0F, 8.0F, 5.0F, 4.0F, 0.0F, false);
		chest.setTextureOffset(26, 29).addBox(1.0F, -34.0F, 4.0F, 3.0F, 11.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(16, 27).addBox(-4.0F, -34.0F, 4.0F, 3.0F, 11.0F, 2.0F, 0.0F, false);

		slants = new ModelRenderer(this);
		slants.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(slants);
		setRotationAngle(slants, -0.0873F, 0.0F, 0.0F);
		slants.setTextureOffset(6, 46).addBox(-5.0F, -27.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		slants2 = new ModelRenderer(this);
		slants2.setRotationPoint(9.0F, 0.0F, 0.0F);
		chest.addChild(slants2);
		setRotationAngle(slants2, -0.0873F, 0.0F, 0.0F);
		slants2.setTextureOffset(32, 45).addBox(-5.0F, -27.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
		slants2.setTextureOffset(0, 35).addBox(-10.0F, -27.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(48, 26).addBox(-1.0F, -43.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, -9.0F);
		head.addChild(bone3);
		setRotationAngle(bone3, -0.2618F, 0.0F, 0.0F);
		bone3.setTextureOffset(46, 0).addBox(-1.0F, -42.0F, 0.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -39.0F, 0.0F);
		head.addChild(bone4);
		setRotationAngle(bone4, 0.2182F, 0.0F, 0.0F);
		bone4.setTextureOffset(21, 11).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 7.0F, 0.0F, false);
		bone4.setTextureOffset(0, 27).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		bone4.setTextureOffset(47, 18).addBox(-1.0F, -3.0F, 3.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -40.0F, 7.0F);
		head.addChild(bone5);
		setRotationAngle(bone5, 0.2182F, 0.0F, 0.0F);
		bone5.setTextureOffset(0, 27).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(28, 5).addBox(1.0F, -5.6493F, -3.9289F, 0.0F, 5.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -6.0F, -27.0F);
		head.addChild(bone11);
		setRotationAngle(bone11, -0.6981F, 0.0F, 0.0F);
		bone11.setTextureOffset(32, 21).addBox(-1.0F, -42.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-7.0F, -33.0F, 0.0F);
		body.addChild(bone6);
		bone6.setTextureOffset(46, 23).addBox(0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		bone6.setTextureOffset(24, 21).addBox(11.0F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -2.0F, 1.0F);
		bone6.addChild(bone7);
		setRotationAngle(bone7, -0.3927F, 0.0F, 0.0F);
		bone7.setTextureOffset(36, 36).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		bone7.setTextureOffset(8, 35).addBox(14.0F, 0.0F, 1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 7.0F, -1.0F);
		bone6.addChild(bone8);
		setRotationAngle(bone8, -0.829F, -0.7418F, 0.0F);
		bone8.setTextureOffset(44, 44).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(14.0F, 8.0F, -1.0F);
		bone6.addChild(bone9);
		setRotationAngle(bone9, -1.0036F, 1.0908F, 0.0F);
		bone9.setTextureOffset(32, 6).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(5.0F, 10.0F, -9.0F);
		bone6.addChild(bone10);
		setRotationAngle(bone10, -0.2182F, 0.48F, 0.48F);
		bone10.setTextureOffset(0, 0).addBox(-7.0F, -1.0F, 4.0F, 18.0F, 2.0F, 2.0F, 0.0F, false);
		bone10.setTextureOffset(39, 17).addBox(-7.0F, -1.0F, 4.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone10.setTextureOffset(48, 8).addBox(-5.1153F, 0.3865F, 3.7965F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone10.setTextureOffset(36, 29).addBox(-1.1565F, 0.8836F, 3.7984F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone10.setTextureOffset(10, 27).addBox(-0.3697F, 0.3441F, 4.0983F, 1.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}