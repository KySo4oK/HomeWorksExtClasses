package com.company;

public class Adapter {

    public static void main(String[] args) {
        VectorGraphicInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorGraphicInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicInterface {
    RasterGraphics rasterGraphics;

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
