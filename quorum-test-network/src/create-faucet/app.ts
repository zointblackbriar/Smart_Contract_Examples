// tslint:disable: no-console

import { OrchestrateClient } from "pegasys-orchestrate";

export const start = async () => {
  try {
    const faucetRegistry = new OrchestrateClient(process.env.API_HOST!);

    const faucet = await faucetRegistry.registerFaucet(
      {
        name: `${process.env.CHAIN}-faucet`,
        chainRule: process.env.CHAIN_UUID!,
        creditorAccount: process.env.FAUCET_ACCOUNT!,
        cooldown: "10s",
        amount: "60000000000000000",
        maxBalance: "100000000000000000",
      },
      process.env.AUTH_TOKEN
    );

    console.log(faucet);
  } catch (error) {
    console.error(error);
  }
};
