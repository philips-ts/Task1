package com.tarasenko.gof_patterns.structutal;


interface LightningCharger {
    void charge();
}

interface USBTypeC {
    void charge();
}


class Iphone implements LightningCharger {
    @Override
    public void charge() {
        System.out.println("Charging..");
    }
}

class USBTypeCAdapter implements USBTypeC {
    private final LightningCharger lightningChargerDevice;

    public USBTypeCAdapter(LightningCharger lightningChargerDevice) {
        this.lightningChargerDevice = lightningChargerDevice;
    }

    @Override
    public void charge() {
        lightningChargerDevice.charge();
    }
}


public class Adapter {
    public static void main(String[] args) {
        LightningCharger iphone = new Iphone();
        USBTypeCAdapter adapter = new USBTypeCAdapter(iphone);
        adapter.charge();
    }
}
