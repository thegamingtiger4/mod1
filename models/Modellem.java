// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modellem extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer rightleg;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer leftleg;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer bodycenter2;
	private final ModelRenderer bodycenter3;
	private final ModelRenderer bodycenter;

	public Modellem() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(13.0F, 24.0F, 0.0F);
		setRotationAngle(body, 0.0F, 3.1416F, 0.0F);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(11.36F, -80.92F, -7.48F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(0, 0).addBox(-13.36F, 78.92F, -14.52F, 2.0F, 2.0F, 24.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-15.36F, 76.92F, -14.52F, 6.0F, 2.0F, 24.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-15.36F, 78.92F, -6.52F, 6.0F, 2.0F, 24.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-11.36F, 78.92F, -14.52F, 2.0F, 2.0F, 24.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-9.36F, 78.92F, -12.52F, 2.0F, 2.0F, 20.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-7.36F, 78.92F, -10.52F, 2.0F, 2.0F, 18.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-5.36F, 78.92F, -10.52F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-15.36F, 78.92F, -14.52F, 2.0F, 2.0F, 24.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-17.36F, 78.92F, -12.52F, 2.0F, 2.0F, 20.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-19.36F, 78.92F, -10.52F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-21.36F, 78.92F, -8.52F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-15.36F, 40.92F, -20.52F, 2.0F, 28.0F, 6.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-11.36F, 40.92F, -20.52F, 2.0F, 28.0F, 6.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-13.36F, 40.92F, -18.52F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-13.36F, 12.92F, -14.52F, 2.0F, 28.0F, 2.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-15.36F, 12.92F, -20.52F, 6.0F, 28.0F, 6.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-17.36F, 14.92F, -18.52F);
		rightleg.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.8727F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(0.0F, -8.0F, -4.0F, 2.0F, 8.0F, 6.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(2.0F, -22.0F, -4.0F, 6.0F, 22.0F, 6.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-11.36F, 78.92F, -8.52F);
		rightleg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.6109F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-2.0F, -16.0F, -4.0F, 2.0F, 16.0F, 6.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-21.36F, 80.92F, 1.48F);
		rightleg.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(-10.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-19.36F, 80.92F, -8.52F);
		rightleg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -2.3562F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(-10.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-3.36F, 80.92F, -10.52F);
		rightleg.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.6109F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(-10.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-1.36F, 80.92F, 1.48F);
		rightleg.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -1.5708F, 0.0F);
		cube_r6.setTextureOffset(0, 0).addBox(-10.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-3.36F, 80.92F, 3.48F);
		rightleg.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.6109F, 0.0F);
		cube_r7.setTextureOffset(0, 0).addBox(-10.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-13.36F, 80.92F, 7.48F);
		rightleg.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -0.6109F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(-10.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(63.5217F, -80.087F, -8.7826F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(0, 0).addBox(-11.5217F, 78.087F, -11.2174F, 2.0F, 2.0F, 22.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-15.5217F, 76.087F, -11.2174F, 6.0F, 2.0F, 22.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-15.5217F, 78.087F, -3.2174F, 6.0F, 2.0F, 22.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-13.5217F, 78.087F, -11.2174F, 2.0F, 2.0F, 22.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-7.5217F, 78.087F, -7.2174F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-9.5217F, 78.087F, -9.2174F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-15.5217F, 78.087F, -9.2174F, 2.0F, 2.0F, 18.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-17.5217F, 78.087F, -9.2174F, 2.0F, 2.0F, 18.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-19.5217F, 78.087F, -7.2174F, 2.0F, 2.0F, 14.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-15.5217F, 40.087F, -17.2174F, 2.0F, 28.0F, 6.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-11.5217F, 40.087F, -17.2174F, 2.0F, 28.0F, 6.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-13.5217F, 40.087F, -15.2174F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-13.5217F, 12.087F, -11.2174F, 2.0F, 28.0F, 2.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(-15.5217F, 12.087F, -17.2174F, 6.0F, 28.0F, 6.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-5.5217F, 12.087F, -13.2174F);
		leftleg.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.8727F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 2.0F, 8.0F, 6.0F, 0.0F, false);
		cube_r9.setTextureOffset(0, 0).addBox(-10.0F, -18.0F, -4.0F, 6.0F, 22.0F, 6.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-11.5217F, 76.087F, 0.7826F);
		leftleg.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.6109F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(-2.0F, -18.0F, -10.0F, 2.0F, 18.0F, 6.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(6.4783F, 80.087F, 4.7826F);
		leftleg.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 2.4435F, 0.0F);
		cube_r11.setTextureOffset(0, 0).addBox(14.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.4783F, 80.087F, -19.2174F);
		leftleg.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -2.5307F, 0.0F);
		cube_r12.setTextureOffset(0, 0).addBox(14.0F, -2.0F, -12.0F, 12.0F, 2.0F, 14.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-3.5217F, 80.087F, -19.2174F);
		leftleg.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -1.5708F, 0.0F);
		cube_r13.setTextureOffset(0, 0).addBox(14.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-19.5217F, 80.087F, -19.2174F);
		leftleg.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -1.5708F, 0.0F);
		cube_r14.setTextureOffset(0, 0).addBox(14.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-25.5217F, 80.087F, 20.7826F);
		leftleg.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.6109F, 0.0F);
		cube_r15.setTextureOffset(0, 0).addBox(16.0F, -2.0F, -14.0F, 10.0F, 2.0F, 16.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-31.5217F, 80.087F, -3.2174F);
		leftleg.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, -0.6109F, 0.0F);
		cube_r16.setTextureOffset(0, 0).addBox(14.0F, -2.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		bodycenter2 = new ModelRenderer(this);
		bodycenter2.setRotationPoint(39.0F, -78.0F, -8.0F);
		body.addChild(bodycenter2);
		bodycenter2.setTextureOffset(0, 0).addBox(-31.0F, -4.0F, -10.0F, 36.0F, 4.0F, 42.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-31.0F, -20.0F, -4.0F, 2.0F, 16.0F, 34.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(3.0F, -20.0F, -4.0F, 2.0F, 16.0F, 34.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-31.0F, -36.0F, -4.0F, 2.0F, 16.0F, 30.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(3.0F, -36.0F, -4.0F, 2.0F, 16.0F, 30.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-29.0F, -36.0F, -4.0F, 34.0F, 32.0F, 2.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-31.0F, -38.0F, -4.0F, 36.0F, 2.0F, 30.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(5.0F, -24.0F, 2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-39.0F, -24.0F, 2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-41.0F, -26.0F, 0.0F, 2.0F, 8.0F, 8.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(9.0F, -24.0F, 2.0F, 4.0F, 4.0F, 14.0F, 0.0F, false);

		bodycenter3 = new ModelRenderer(this);
		bodycenter3.setRotationPoint(39.0F, -108.0F, 16.0F);
		body.addChild(bodycenter3);
		setRotationAngle(bodycenter3, -1.3963F, 0.0F, 0.0F);
		bodycenter3.setTextureOffset(0, 0).addBox(-31.0F, -4.0F, -6.0F, 36.0F, 4.0F, 38.0F, 0.0F, false);

		bodycenter = new ModelRenderer(this);
		bodycenter.setRotationPoint(39.0F, -78.0F, -12.0F);
		body.addChild(bodycenter);
		bodycenter.setTextureOffset(0, 0).addBox(-43.0F, -4.0F, 2.0F, 60.0F, 4.0F, 4.0F, 0.0F, false);
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
	}
}